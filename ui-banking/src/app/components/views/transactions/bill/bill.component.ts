import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { bill } from 'src/app/models/bill';
import { TransactionService } from 'src/app/services/transaction/transaction.service';

@Component({
  selector: 'app-bill',
  templateUrl: './bill.component.html',
  styleUrls: ['./bill.component.scss']
})
export class BillComponent {
  billRequest: bill = new bill()
  accountNumber: string;

  constructor(
    private http: HttpClient,
    private transactionService: TransactionService
  ) { }

  onSubmit() {
    let userAc = localStorage.getItem('user_dtls_ac') || '{}';
    console.log(JSON.parse(userAc).userAccount.accountNumber);
    // this.accountNumber = JSON.parse(userAc).userAccount.accountNumber;

    this.billRequest.customerAN = JSON.parse(userAc).userAccount.accountNumber;
    this.transactionService.billPayment(this.billRequest).subscribe((response) => {
      console.log('Response from API:', response);
    }, (error) => {
      // Handle errors, if any
      console.error('Error:', error);
    });
    // const apiEndpoint = 'http://127.0.0.1:8081/api/v1/bill/pay';
    // this.billRequest.customerAN = '1432648625'
    // console.log(this.billRequest)
    // // Make the HTTP POST request
    // this.http.post(apiEndpoint, this.billRequest).subscribe(
    //   (response) => {
    //     // Handle successful response from the API
    //     console.log('Response from API:', response);
    //   },
    //   (error) => {
    //     // Handle errors, if any
    //     console.error('Error:', error);
    //   }
    // );
  }
}
