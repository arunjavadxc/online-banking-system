import { Component, Input, OnInit } from '@angular/core';
import { FooterComponent } from '../../shared/footer/footer.component';
import { Router } from '@angular/router';
import { UserService } from 'src/app/services/user/user.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent implements OnInit{

  @Input() footer: FooterComponent;
  username : '';
  sideBarToggled = false;
  public isCollapsed = false;
  user: any;
  currentBalance : 0;

  constructor(
    private router: Router,
    private userService: UserService){}

  ngOnInit(): void {
    this.getUserDetails();
  }

  getUserDetails() {
    this.userService.getLoggedInUserDtls().subscribe((response) => {
      this.user = response.body.responseObj;
      console.log('User response ->' + JSON.stringify(this.user));
      localStorage.setItem('user_obj',JSON.stringify(this.user));
      this.username = this.user.firstName + this.user.lastName;
      /**
       * Get the account details of the user
       */
      this.userService.getUserByUserID(this.user.userID).subscribe((response) =>{
        console.log('Complete user details ->' + JSON.stringify(response.body.responseObj));
        localStorage.setItem('user_dtls_ac', JSON.stringify(response.body.responseObj));
      });
    });


  }

  sideBarToggle() {   
    console.log('Toggle button clicked');
    this.sideBarToggled = !this.sideBarToggled;
  }

  logout() {
    // this.router.navigate(['/']);
  }

}
