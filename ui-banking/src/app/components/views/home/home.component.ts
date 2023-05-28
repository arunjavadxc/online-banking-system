import { Component } from '@angular/core';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent {

  sideBarToggled = false;
  public isCollapsed = false;

  constructor() {}

  updateSideBar() {   
    this.sideBarToggled = !this.sideBarToggled;
  }

}
