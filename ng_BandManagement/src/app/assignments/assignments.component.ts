import { Component, OnInit, ɵConsole } from '@angular/core';
import { Router } from '@angular/router';
import { Assignment } from '../classes/assignment';
import { AssignmentService } from '../services/assignment.service';
import { AssignmentTypeService } from '../services/assignment-type.service';
import { AssignmentType } from '../classes/assignment-type';

@Component({
  selector: 'app-assignments',
  templateUrl: './assignments.component.html',
  styleUrls: ['./assignments.component.css']
})
export class AssignmentsComponent implements OnInit {
  public assignmentTypeList: AssignmentType[];
  public assignment: Assignment;

  constructor(
    public route: Router,
    private assignmentService: AssignmentService

    ) { }

  ngOnInit(): void { 
    //Create assignment
    this.assignment = new Assignment();
    console.log("New Assignment "+this.assignment);

  }
  submit(): void {
    console.log(this.assignment);
    this.assignmentService.updateAssignment(this.assignment).subscribe(
      assignment => {
        this.assignment = assignment;
        console.log("Assignment "+ this.assignment);
        this.route.navigate(['/assignments/instructor']);
      }
    );


  


  }
}
