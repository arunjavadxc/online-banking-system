import { Component, OnInit } from '@angular/core';
import { ActivatedRoute } from '@angular/router';
import { success } from 'src/app/models/success';

@Component({
  selector: 'app-success',
  templateUrl: './success.component.html',
  styleUrls: ['./success.component.scss']
})
export class SuccessComponent implements OnInit {
  id:success
  constructor(private route: ActivatedRoute) {}
  ngOnInit() {
    this.route.queryParams.subscribe((params) => {
      this.id =new success(JSON.parse(params['data']));
      console.log(this.id);

      // Now you have the 'id' query parameter and can use it as needed
    });
  }
}
