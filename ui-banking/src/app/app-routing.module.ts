import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/views/login/login.component';
import { RegistrationComponent } from './components/views/registration/registration.component';
import { DashboardComponent } from './components/views/dashboard/dashboard.component';
import { HomeComponent } from './components/views/home/home.component';
import { SignupComponent } from './components/views/signup/signup.component';
import { ForgetpasswordComponent } from './components/views/forgetpassword/forgetpassword.component';
import { TransactionsComponent } from './components/views/transactions/transactions.component';
import { TransferComponent } from './components/views/transactions/transfer/transfer.component';
import { StatementComponent } from './components/views/transactions/statement/statement.component';
import { BillComponent } from './components/views/transactions/bill/bill.component';
import { ProfileComponent } from './components/views/profile/profile.component';
import { LoanComponent } from './components/views/loan/loan.component';
import { ApplyComponent } from './components/views/loan/apply/apply.component';
import { SuccessComponent } from './components/views/loan/success/success.component';
import { PayComponent } from './components/views/loan/pay/pay.component';


const routes: Routes = [
  { path: '', redirectTo: '/home/dashboard', pathMatch: 'full' },
  // { path: 'login', component: LoginComponent },
  // { path: 'signup', component: SignupComponent },
  // { path: 'forgetpwd', component: ForgetpasswordComponent },
  {
    path: 'home', component: HomeComponent,
    children: [
      { path: 'dashboard', component: DashboardComponent},
      { path: 'transactions', component: TransactionsComponent },
      { path: 'transfer', component: TransferComponent },
      { path: 'bill', component: BillComponent },
      { path: 'statement', component: StatementComponent },
      { path: 'loan', component:LoanComponent},
      { path: 'loan/apply', component:ApplyComponent},
      { path: 'loan/success', component:SuccessComponent},
      { path: 'loan/pay', component:PayComponent}
    ],
  },

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
