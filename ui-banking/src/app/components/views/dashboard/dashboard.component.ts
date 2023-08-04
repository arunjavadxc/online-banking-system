import { Component, OnInit } from '@angular/core';
import { UserService } from 'src/app/services/user/user.service';

@Component({
  selector: 'app-dashboard',
  templateUrl: './dashboard.component.html',
  styleUrls: ['./dashboard.component.scss']
})
export class DashboardComponent implements OnInit {

  currentBalance: number = 0;
  accountNumber: string;

  constructor(private userService: UserService) { }

  ngOnInit() {
    let userAc = localStorage.getItem('user_dtls_ac') || '{}';
    console.log(JSON.parse(userAc).userAccount.accountNumber);
    this.accountNumber = JSON.parse(userAc).userAccount.accountNumber;

    this.getCurrentBalance();
  }

  getCurrentBalance() {

    this.userService.getCurrentBalance(this.accountNumber).subscribe((response) => {
      console.log(response);
      this.currentBalance = response.body.balance;
    });
  }

}
