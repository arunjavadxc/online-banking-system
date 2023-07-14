import { Component } from '@angular/core';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent {
  title = 'ui-banking';

  sideBarToggled = false;
  public isCollapsed = false;

  constructor() {}

  updateSideBar() {   
    this.sideBarToggled = !this.sideBarToggled;
  }

}
