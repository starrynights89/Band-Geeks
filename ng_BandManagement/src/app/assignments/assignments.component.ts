import { Component, OnInit, ɵConsole } from '@angular/core';
import { Router } from '@angular/router';
import { Assignment } from '../classes/assignment';
import { AssignmentService } from '../services/assignment.service';
import { AssignmentTypeService } from '../services/assignment-type.service';
import { AssignmentType } from '../classes/assignment-type';
import { LoginService } from '../services/login.service';
import { Currentuser } from '../classes/currentuser';

@Component({
  selector: 'app-assignments',
  templateUrl: './assignments.component.html',
  styleUrls: ['./assignments.component.css']
})
export class AssignmentsComponent implements OnInit {
  public assignments: Assignment[];
  public assignmentTypeList: AssignmentType[];
  public assignment: Assignment;
  public loggedUser: Currentuser;

  constructor(
    public route: Router,
    private assignmentService: AssignmentService,
    private loginService: LoginService


    ) { }

  ngOnInit(): void { 
    //Create assignment
    this.assignment = new Assignment();
    console.log("New Assignment "+this.assignment);

    //get assignments for 
    this.assignmentService.getAllAssignments().subscribe(
      resp => {
        this.assignments = resp;
        console.log("AssignmentList "+resp);
      }
    );

  }
  set(id: number): void{
    console.log("Assignment id "+id);
    this.assignment.id = id;
    this.assignment.grade = "Ungraded";

  }
  submit(): void {
    console.log(this.assignment);
    this.assignmentService.updateAssignment(this.assignment).subscribe(
      assignment => {
        this.assignment = assignment;
        console.log("Assignment "+ this.assignment);
        this.route.navigate(['/assignments']);
      }
    );
  }

  isStudent(): boolean {
    return this.loginService.isStudent();
  }
  isInstructor(): boolean {
    return this.loginService.isInstructor();
  }
}

