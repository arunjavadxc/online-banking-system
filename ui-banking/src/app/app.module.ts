import { SignupComponent } from './components/views/signup/signup.component';
import { HttpClientModule } from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { ExportAsModule } from 'ngx-export-as';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { LoginComponent } from './components/views/login/login.component';
import { RegistrationComponent } from './components/views/registration/registration.component';
import { ReactiveFormsModule } from '@angular/forms';
import { DashboardComponent } from './components/views/dashboard/dashboard.component';
import { NavbarComponent } from './components/shared/navbar/navbar.component';
import { SidebarComponent } from './components/shared/sidebar/sidebar.component';
import { FooterComponent } from './components/shared/footer/footer.component';
import { HomeComponent } from './components/views/home/home.component';
import { ForgetpasswordComponent } from './components/views/forgetpassword/forgetpassword.component';
import { TransactionsComponent } from './components/views/transactions/transactions.component';
import { TransferComponent } from './components/views/transactions/transfer/transfer.component';
import { StatementComponent } from './components/views/transactions/statement/statement.component';
import { FormsModule } from '@angular/forms';
import { BillComponent } from './components/views/transactions/bill/bill.component';
import { ProfileComponent } from './components/views/profile/profile.component';
import { SuccessComponent } from './components/views/transactions/success/success.component';

@NgModule({
  declarations: [
    AppComponent,
    LoginComponent,
    RegistrationComponent,
    DashboardComponent,
    NavbarComponent,
    SidebarComponent,
    FooterComponent,
    HomeComponent,
    SignupComponent,
    ForgetpasswordComponent,
    TransactionsComponent,
    TransferComponent,
    StatementComponent,
    BillComponent,
    ProfileComponent,
    SuccessComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    HttpClientModule,
    ReactiveFormsModule,
    CommonModule,
    FormsModule,
    ExportAsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
