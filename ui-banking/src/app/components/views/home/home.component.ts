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

  constructor(
    private router: Router,
    private userService: UserService){}

  ngOnInit(): void {
    this.getUserDetails();
  }

  getUserDetails() {
    this.userService.getLoggedInUserDtls().subscribe((response) => {
      console.log(response.data);
    });
  }

  sideBarToggle() {   
    console.log('Toggle button clicked');
    this.sideBarToggled = !this.sideBarToggled;
  }

  logout() {
    this.router.navigate(['login']);
  }

}
