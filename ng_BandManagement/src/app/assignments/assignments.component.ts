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

<<<<<<< HEAD
  ngOnInit(): void { 
    //Create assignment
    this.assignment = new Assignment();
    console.log("New Assignment "+this.assignment);

=======
  ngOnInit(): void {
>>>>>>> fa3b9010483b3d7d827f7afec0fc2a21cfd57815
  }
  submit(): void {
    this.assignmentService.updateAssignment(this.assignment).subscribe(
      assignment => {
        this.assignment = assignment;
        console.log("Assignment "+ this.assignment);
        this.route.navigate(['/assignments/instructor']);
      }
    );


  


  }
}
