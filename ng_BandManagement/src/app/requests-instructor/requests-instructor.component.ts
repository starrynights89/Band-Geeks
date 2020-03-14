import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Request } from '../classes/request';
import { RequestInstructorService } from '../services/request-instructor.service';

@Component({
  selector: 'app-requests-instructor',
  templateUrl: './requests-instructor.component.html',
  styleUrls: ['./requests-instructor.component.css']
})
export class RequestsInstructorComponent implements OnInit {
  public RequestList: Request[];
  public request: Request;
  constructor(
    public route: Router,
    private requestInstructorService: RequestInstructorService
  ) { }

  ngOnInit(): void {
  }
  submit(): void {
    this.requestInstructorService.updateRequest(this.request).subscribe(
      request => {
        this.request = request;
        this.route.navigate(['/requests/instructor']);
      }
    );


  


  }

}
