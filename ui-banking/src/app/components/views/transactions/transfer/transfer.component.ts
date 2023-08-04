import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { transfer } from 'src/app/models/transfer';
import { TransactionService } from 'src/app/services/transaction/transaction.service';

@Component({
  selector: 'app-transfer',
  templateUrl: './transfer.component.html',
  styleUrls: ['./transfer.component.scss'],

})
export class TransferComponent {
  formData: transfer = new transfer();
  constructor(private transService: TransactionService) { }


  onSubmit() {
    console.log('Entry into onsubmit method')
    let userAc = localStorage.getItem('user_dtls_ac') || '{}';
    console.log(JSON.parse(userAc).userAccount.accountNumber);
    this.formData.debitParty = JSON.parse(userAc).userAccount.accountNumber;

    console.log(this.formData)
    // Make the HTTP POST request
    this.transService.transferAmount(this.formData).subscribe((response) => {
      console.log(response);
      alert('Transfer success');
      this.formData = new transfer();
    });
  }
}
