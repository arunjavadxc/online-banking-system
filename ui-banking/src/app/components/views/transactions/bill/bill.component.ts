import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { Mail } from 'src/app/models/Mail';
import { bill } from 'src/app/models/bill';
import { NotificationService } from 'src/app/services/notification/notification.service';
import { TransactionService } from 'src/app/services/transaction/transaction.service';

@Component({
  selector: 'app-bill',
  templateUrl: './bill.component.html',
  styleUrls: ['./bill.component.scss']
})
export class BillComponent {
  accountNumber: string;
  billRequest: bill = new bill()
  mail: Mail = new Mail();

  constructor(
    private http: HttpClient,
    private transactionService: TransactionService,
    private notificationService: NotificationService
  ) { }

  onSubmit() {
    let userAc = localStorage.getItem('user_dtls_ac') || '{}';

    this.accountNumber = JSON.parse(userAc).userAccount.accountNumber;

    this.billRequest.customerAN = JSON.parse(userAc).userAccount.accountNumber;
    this.transactionService.billPayment(this.billRequest).subscribe((response) => {
      console.log('Response from API:', response);
      alert('Payment Success');

      this.mail.message = 500 + ' amount debited from your account for Bill Payment';
      this.mail.subject = 'Bill Payment alert!'
      this.mail.mailID = JSON.parse(userAc).emailID;

      this.notificationService.sendDebitNotification(this.mail).subscribe((response) => {
        console.log(response);
      });


    }, (error) => {
      alert('Payment Failed due to ' + error)
    });
  }
}
