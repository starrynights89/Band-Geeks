import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Request } from '../classes/request';
import { RequestInstructorService } from '../services/request-instructor.service';
import { Instrument } from '../classes/instrument';
import { Uniform } from '../classes/uniform';
import { InstrumentService } from '../services/instrument.service';
import { UniformService } from '../services/uniform.service';

@Component({
  selector: 'app-requests-instructor',
  templateUrl: './requests-instructor.component.html',
  styleUrls: ['./requests-instructor.component.css']
})
export class RequestsInstructorComponent implements OnInit {
  public instrumentList: Instrument[];
  public uniformList: Uniform[];
  public RequestList: Request[];
  public request: Request;
  public instrument: Instrument;
  public uniform: Uniform;
  constructor(
    public route: Router,
    private requestInstructorService: RequestInstructorService,
    private instrumentService: InstrumentService,
    private uniformService: UniformService
  ) { }

  ngOnInit(): void {
      //get instruments
      this.instrumentService.getAllInstruments().subscribe(
        resp => {
          this.instrumentList = resp;
          console.log("InstrumentList "+resp);
        }
      );
        //get uniforms
        this.uniformService.getAllUniforms().subscribe(
          resp => {
            this.uniformList = resp;
            console.log("UniformList "+resp);
          }
        );
  
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
