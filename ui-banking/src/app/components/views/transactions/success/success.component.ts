import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { response } from 'src/app/models/transferResponse';

@Component({
  selector: 'app-success',
  templateUrl: './success.component.html',
  styleUrls: ['./success.component.scss']
})
export class SuccessComponent implements OnInit {
  response: response
  bill:String
  constructor(private route: ActivatedRoute) {}

  ngOnInit(): void {
    this.route.queryParams.subscribe(params => {
      this.response=new response(JSON.parse((params['transfer'])))  
      console.log(params['transfer']+"\n"+this.response)
    })
    this.route.params.subscribe(params => {
      this.bill=params['Status'];
    })
  }
}
