import { Component, OnInit } from '@angular/core';
import { TransactionService } from 'src/app/services/transaction/transaction.service';
import { UserService } from 'src/app/services/user/user.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {

  currentBalance: number = 0;
  accountNumber: string;
  totalDebits: number = 0;
  totalCredits: number = 0;

  constructor(private userService: UserService,
    private transactionService: TransactionService) { }

  ngOnInit() {
    let userAc = localStorage.getItem('user_dtls_ac') || '{}';
    console.log(JSON.parse(userAc).userAccount.accountNumber);
    this.accountNumber = JSON.parse(userAc).userAccount.accountNumber;

    this.getCurrentBalance();
    this.getAllTransactions();
  }

  getCurrentBalance() {

    this.userService.getCurrentBalance(this.accountNumber).subscribe((response) => {
      console.log(response);
      this.currentBalance = response.body.balance;
    });
  }

  getAllTransactions() {
    this.transactionService.getAllTransactionFroAccount(this.accountNumber).subscribe((response) => {
      console.log(response);
      let responseContent = response.body;
      for(let val of responseContent) {
        this.totalCredits += val.amountDeposit;
        this.totalDebits += val.amountWithdraw;
      }
    })
  }
}
