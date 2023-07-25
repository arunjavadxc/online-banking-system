import { HttpClient } from '@angular/common/http';
import { Component } from '@angular/core';
import { transfer } from 'src/app/models/transfer';

@Component({
  selector: 'app-transfer',
  templateUrl: './transfer.component.html',
  styleUrls: ['./transfer.component.scss'],
  
})
export class TransferComponent {
  formData : transfer = new transfer();
  constructor(private http:HttpClient) { }
  onSubmit() {
    const apiEndpoint = 'http://127.0.0.1:8081/api/v1/transactions'; 
    this.formData.debitParty='1432648625'
    console.log(this.formData)
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
  // formDataValue:formData
  // formData={
  //   creditParty:'',
  // transactionAmount:0,
  // transactionMode:'',
  // debitParty:'1432648625'
  // }
  // constructor(private http: HttpClient) {}

  // onSubmit() {

  //   const apiEndpoint = 'http://127.0.0.1:8081/api/v1/transactions'; 
  //   // this.formDataValue.debitParty="1432648625"
  //   // Make the HTTP POST request
  //   this.http.post(apiEndpoint, this.formData).subscribe(
  //     (response) => {
  //       console.log("Success")
  //       // Handle successful response from the API
  //       console.log('Response from API:', response);
  //     },
  //     (error) => {
  //       // Handle errors, if any
  //       console.error('Error:', error);
  //     }
  //   );
  // }
}

// export class formData{
//   creditParty:string
//   transactionAmount:number
//   transactionMode:string
//   debitParty:string
// }
