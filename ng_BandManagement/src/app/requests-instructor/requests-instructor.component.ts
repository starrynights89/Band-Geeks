import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Request } from '../classes/request';
import { RequestInstructorService } from '../services/request-instructor.service';
import { Instrument } from '../classes/instrument';
import { Uniform } from '../classes/uniform';
import { InstrumentService } from '../services/instrument.service';
import { UniformService } from '../services/uniform.service';
import { Inventory } from '../classes/inventory';

@Component({
  selector: 'app-requests-instructor',
  templateUrl: './requests-instructor.component.html',
  styleUrls: ['./requests-instructor.component.css']
})
export class RequestsInstructorComponent implements OnInit {
  public instrumentList: Instrument[];
  public uniformList: Uniform[];
  public requestList: Request[];
  public request: Request;
  public inventory: Inventory;
  public instrument: Instrument;
  public uniform: Uniform;
  constructor(
    public route: Router,
    private requestInstructorService: RequestInstructorService,
    private instrumentService: InstrumentService,
    private uniformService: UniformService
  ) { }
public itemName;


  ngOnInit(): void {
      //get instruments
      this.instrumentService.getAllInstruments().subscribe(
        resp => {
          this.instrumentList = resp;
          console.log("InstrumentList "+resp);
          console.log(this.instrumentList);
        }
      );
        //get uniforms
        this.uniformService.getAllUniforms().subscribe(
          resp => {
            this.uniformList = resp;
            console.log("UniformList "+resp);
            console.log(this.uniformList);
          }
        );
          //get requests
          this.requestInstructorService.getAllRequests().subscribe(
            resp => {
              this.requestList = resp;
              console.log("RequestList "+resp);
              console.log(this.requestList);
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
