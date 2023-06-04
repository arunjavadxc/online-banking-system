import { Component, Input } from '@angular/core';
import { FooterComponent } from '../../shared/footer/footer.component';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.scss']
})
export class HomeComponent {

  @Input() footer: FooterComponent;

  sideBarToggled = false;
  public isCollapsed = false;

  constructor() {}

  updateSideBar() {   
    this.sideBarToggled = !this.sideBarToggled;
  }

}
