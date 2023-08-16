import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { loan } from 'src/app/models/loan';
import { LoanService } from 'src/app/services/loan/loan.service';

@Component({
  selector: 'app-apply',
  templateUrl: './apply.component.html',
  styleUrls: ['./apply.component.scss']
})
export class ApplyComponent {
  Loan:loan = new loan();
  constructor(private loanService:LoanService,private route: Router){}
  calculateLoan(){
    console.log(this.Loan)
    let userAc = localStorage.getItem('user_dtls_ac') || '{}';
    this.Loan.accountNo = JSON.parse(userAc).userAccount.accountNumber;
    // this.Loan.accountNo="1432354780"
    this.loanService.applyLoan(this.Loan).subscribe((response)=>{
      console.log(response)
      this.route.navigate(['home/loan/success'],{ queryParams: { data:JSON.stringify(response.body) } });
    })
  }
}
