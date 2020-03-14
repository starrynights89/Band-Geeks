import { Component } from '@angular/core';

@Component({
  //changed selector to pm-products to make sure it works
  selector: 'app-root',
  template: `<pm-products></pm-products>`,
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'BandManagement';
  view = 'home';
}