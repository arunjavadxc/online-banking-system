import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { transfer } from '../models/transfer';
@Injectable({
  providedIn: 'root'
})
export class TransactionService {
  creditParty :string
  transactionAmount : number
  transactionMode :string
  formData : transfer
  constructor(private http:HttpClient) { }
  onSubmit() {
    const apiEndpoint = 'http://127.0.0.1:8081/api/v1/transactions'; 
    this.formData.debitParty="1432648625"
    this.formData.creditParty = this.creditParty
    this.formData.transactionAmount = this.transactionAmount
    this.formData.transactionMode = this.transactionMode
    // Make the HTTP POST request
    this.http.post(apiEndpoint, this.formData).subscribe(
      (response) => {
        console.log("Success")
        // Handle successful response from the API
        console.log('Response from API:', response);
      },
      (error) => {
        // Handle errors, if any
        console.error('Error:', error);
      }
    );
  }
}
