import { HttpClient } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { profile } from 'src/app/models/profile';
@Component({
  selector: 'app-profile',
  templateUrl: './profile.component.html',
  styleUrls: ['./profile.component.scss']
})
export class ProfileComponent implements OnInit {
  profileData: profile

  constructor(private http:HttpClient){}
  ngOnInit(): void {
    this.profile()
  }
  url :string= "http://127.0.0.1:8089/api/v1/users/1432470208"
  profile():void{
    this.http.get<any>(this.url).subscribe(
      (data) => {this.profileData = new profile(data)},
      (error) => {console.error(error)}
    )
  }

}
