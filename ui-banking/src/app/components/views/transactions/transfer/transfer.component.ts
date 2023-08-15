
import { Component } from '@angular/core';
import { Mail } from 'src/app/models/Mail';
import { transfer } from 'src/app/models/transfer';
import { NotificationService } from 'src/app/services/notification/notification.service';
import { TransactionService } from 'src/app/services/transaction/transaction.service';

@Component({
  selector: 'app-transfer',
  templateUrl: './transfer.component.html',
  styleUrls: ['./transfer.component.scss'],

})
export class TransferComponent {
  formData: transfer = new transfer();
  mail: Mail = new Mail();
  constructor(
    private transService: TransactionService,
    private notificationService: NotificationService) { }


  onSubmit() {
    console.log('Entry into onsubmit method')
    let userAc = localStorage.getItem('user_dtls_ac') || '{}';
    console.log(JSON.parse(userAc).userAccount.accountNumber);
    this.formData.debitParty = JSON.parse(userAc).userAccount.accountNumber;

    console.log(this.formData)
    // Make the HTTP POST request
    this.transService.transferAmount(this.formData).subscribe((response) => {
      console.log(response);
      let userAc = localStorage.getItem('user_dtls_ac') || '{}';
      alert('Transfer success');
      this.mail.message = this.formData.transactionAmount + ' amount debited from your account';
      this.mail.subject = 'Transaction alert!'
      this.mail.mailID = JSON.parse(userAc).emailID;
      this.formData = new transfer();

      this.notificationService.sendDebitNotification(this.mail).subscribe((response) => {
        console.log(response);
      });

    });
  }
}
