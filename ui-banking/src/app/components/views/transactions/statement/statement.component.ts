import {transactionStatement} from 'src/app/models/transactionStatement';
import { HttpClient } from '@angular/common/http';
import { Component, Input, OnInit } from '@angular/core';

@Component({
  selector: 'app-statement',
  templateUrl: './statement.component.html',
  styleUrls: ['./statement.component.scss']
})
export class StatementComponent implements OnInit{
  transactions: transactionStatement[] = [];
  constructor(private http: HttpClient) { }
  ngOnInit(): void {
    this.transitionData()
  }
  url: string = 'http://127.0.0.1:8081/api/v1/transactions/1432648625'
  transitionData(): void {
    this.http.get<any[]>(this.url).subscribe(
      (data)=>{
        this.transactions = data.map((transData)=>new transactionStatement(transData))
      },
      (error)=>{
        console.error(error)
      }
    )
  }

}
