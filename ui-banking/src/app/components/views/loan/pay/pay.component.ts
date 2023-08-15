import { Component } from '@angular/core';
import { LoanService } from 'src/app/services/loan/loan.service';

@Component({
  selector: 'app-pay',
  templateUrl: './pay.component.html',
  styleUrls: ['./pay.component.scss']
})
export class PayComponent {
  accountNumber: {accountNumber: String}

  constructor(private loanService:LoanService){}

  payLoan(){
    this.loanService.payLoan(this.accountNumber).subscribe((response)=>{
      console.log(response);
    },
    (Error)=>{
      console.error(Error);
    }
    )
  }
}
