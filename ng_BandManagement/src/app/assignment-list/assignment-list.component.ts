import { Component, OnInit, Input } from '@angular/core';
import { AssignmentService } from '../services/assignment.service';
import { Assignment } from '../classes/assignment';
import { LoginService } from '../services/login.service';
import { Currentuser } from '../classes/currentuser';

@Component({
  selector: 'app-assignment-list',
  templateUrl: './assignment-list.component.html',
  styleUrls: ['./assignment-list.component.css']
})
export class AssignmentListComponent implements OnInit {
  @Input() assignment: Assignment[];
  public loggedUser: Currentuser;

  constructor(
    private assignmentService: AssignmentService,
    private loginService: LoginService

    ) { }

  ngOnInit(): void {
    this.loginService.login(null, null).subscribe(resp => {
      this.loggedUser = resp;
    });
    this.assignmentService.getAllAssignments(this.loggedUser.instructor.id).subscribe(
      resp => {
        this.assignment = resp;
      }
    );

  }

}
