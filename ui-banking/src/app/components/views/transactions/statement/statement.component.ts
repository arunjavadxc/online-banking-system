import { transactionStatement } from 'src/app/models/transactionStatement';
import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { ExportAsService, ExportAsConfig, SupportedExtensions } from 'ngx-export-as';
import { TransactionService } from 'src/app/services/transaction/transaction.service';
@Component({
  selector: 'app-statement',
  templateUrl: './statement.component.html',
  styleUrls: ['./statement.component.scss']
})
export class StatementComponent implements OnInit {
  transactions: transactionStatement[] = [];
  accountNumber: string;

  constructor(
      private http: HttpClient, 
      private exportAsService: ExportAsService,
      private transactionService: TransactionService) { }
 
 
  ngOnInit(): void {
    this.getAllTransactions();
  }

  getAllTransactions() {
    let userAc = localStorage.getItem('user_dtls_ac') || '{}';
    console.log(JSON.parse(userAc).userAccount.accountNumber);
    this.accountNumber = JSON.parse(userAc).userAccount.accountNumber;

    this.transactionService.getAllTransactionFroAccount(this.accountNumber).subscribe((response) => {
      this.transactions = response.body;
    });
  }

  exportTable(type: SupportedExtensions) {
    const exportConfig: ExportAsConfig = {
      type: type,
      elementIdOrContent: 'userStatement', // ID of the table or table content to export

    };
    this.exportAsService.save(exportConfig, 'table_export').subscribe(() => {
      // Save completed
    });
  }
  url: string = 'http://127.0.0.1:8081/api/v1/transactions/1432648625'
  transitionData(): void {
    this.http.get<any[]>(this.url).subscribe(
      (data) => {
        this.transactions = data.map((transData) => new transactionStatement(transData))
      },
      (error) => {
        console.error(error)
      }
    )
  }

}
