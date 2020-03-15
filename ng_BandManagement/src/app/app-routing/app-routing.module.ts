import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { LoginComponent } from '../login/login.component';
import { UserDetailComponent } from '../user-detail/user-detail.component';
// import { UsersComponent } from '../users/users.component';
import { ChatHomeComponent } from '../chat-home/chat-home.component';
import { AssignmentsComponent } from '../assignments/assignments.component';
import { ProductListComponent } from '../products/product-list.component';

// Routes tells the Router which view to display when a user clicks a
// link or pases a URL into the browser
const routes: Routes = [
  {
    path: '',
    redirectTo: '/home',
    pathMatch: 'full'
  },
  {
    path: 'home',
    component: UserDetailComponent
  },
  {
    path: 'contact',
    component: ChatHomeComponent
  },
  {
    path: 'login',
    component: LoginComponent
  },
  {
    path: 'assignments/instructor',
    component: AssignmentsComponent
  },
  {
    path: 'inventory',
    component: ProductListComponent
  }
];

@NgModule({
  // forRoot() method supplies the service providers and directives needed for
  // routing and prrforms the initial navigation based on the browser URL
  imports: [RouterModule.forRoot(routes)],
  // AppRoutingModule exports RouterModule so it will be available throughout the
  // app
  exports: [RouterModule]
})

// AppRoutingModule imports RouterModule and Routes so the app can have
// routing functinality.
export class AppRoutingModule { }
