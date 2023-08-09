import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { LoginComponent } from './components/views/login/login.component';
import { RegistrationComponent } from './components/views/registration/registration.component';
import { DashboardComponent } from './components/views/dashboard/dashboard.component';
import { HomeComponent } from './components/views/home/home.component';
import { SignupComponent } from './components/views/signup/signup.component';
import { ForgetpasswordComponent } from './components/views/forgetpassword/forgetpassword.component';
import { LoanComponent } from './components/views/loan/loan.component';
import { TransactionsComponent } from './components/views/transactions/transactions.component';
import { TransferComponent } from './components/views/transactions/transfer/transfer.component';
import { StatementComponent } from './components/views/transactions/statement/statement.component';
import { BillComponent } from './components/views/transactions/bill/bill.component';
import { ProfileComponent } from './components/views/profile/profile.component';

const routes: Routes = [
  { path: '', component: HomeComponent},
  { path: 'login', component: LoginComponent },
  { path: 'signup', component: SignupComponent },
  { path: 'forgetpwd', component: ForgetpasswordComponent },
  {
    path: 'home', component: HomeComponent,
    children: [{
      path: 'dashboard', component: DashboardComponent
    },
    {path:'transactions',component: TransactionsComponent},
    {path:'transactions/transfer',component: TransferComponent},
    {path:'transactions/statement',component:StatementComponent},
    {path:'transactions/bill',component:BillComponent},
    {path:'profile',component: ProfileComponent}
    ]
  },
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
