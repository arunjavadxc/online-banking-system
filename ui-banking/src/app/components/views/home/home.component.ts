import { Component, Input } from '@angular/core';
import { FooterComponent } from '../../shared/footer/footer.component';
import { Router } from '@angular/router';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent {

  @Input() footer: FooterComponent;
  username : 'Arun Kumar V';
  sideBarToggled = false;
  public isCollapsed = false;

  constructor(private router: Router){}

  sideBarToggle() {   
    console.log('Toggle button clicked');
    this.sideBarToggled = !this.sideBarToggled;
  }

  logout() {
    this.router.navigate(['login']);
  }

}
