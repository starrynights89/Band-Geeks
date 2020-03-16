import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Request } from '../classes/request';
import { RequestInstructorService } from '../services/request-instructor.service';
import { Instrument } from '../classes/instrument';
import { Uniform } from '../classes/uniform';
import { InstrumentService } from '../services/instrument.service';
import { UniformService } from '../services/uniform.service';
import { Inventory } from '../classes/inventory';
import { LoginService } from '../services/login.service';
import { Status } from '../classes/status';

@Component({
  selector: 'app-requests-instructor',
  templateUrl: './requests-instructor.component.html',
  styleUrls: ['./requests-instructor.component.css']
})
export class RequestsInstructorComponent implements OnInit {
  public instrumentList: Instrument[];
  public uniformList: Uniform[];
  public requestList: Request[];
  public reqList: Request[];
  public request: Request;
  public inventory: Inventory;
  public instrument: Instrument;
  public uniform: Uniform;
  inst: Instrument;
  uni: Uniform;

  constructor(
    public route: Router,
    private requestInstructorService: RequestInstructorService,
    private instrumentService: InstrumentService,
    private uniformService: UniformService,
    private loginService: LoginService
  ) { }
public itemName: string; 
 

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
              for (let r of this.requestList){
                let r = new Request();
                console.log(r);
                this.reqList.push(r);
              }
    
              console.log("RequestList "+resp);
              console.log(this.requestList);
              console.log(this.reqList)
            }
          );
  }

  submit(type, name): void {
    
    if (type == 1){
      let inst = new Instrument();
      inst.instrumentName = name;
      console.log(inst);

      this.instrumentService.updateInstrument(inst).subscribe(
      inst => {
       this.inst = inst;
        this.route.navigate(['/requests/instructor/']);
      }
    );
    alert("Instrument added!");


    }else if (type == 2) {
      let uni = new Uniform();
      uni.uniformName = name;
      console.log(uni);

      this.uniformService.updateUniform(uni).subscribe(
        uni => {
          this.uni = uni;
          this.route.navigate(['/uniform']);
        }
      );
      alert("Uniform Added!");
    }
    else{alert("Select a type!")}
  }

  acceptReq(request: Request):void {
    console.log(request);
    let today = new Date();
    let sixMon = new Date(today.getTime() + (180*24*60*60*1000))
    request.status = new Status();
    request.status.statusId = 2;
    request.status.statusType = 'ACCEPTED';
    request.checkIn = today;
    request.checkOut = sixMon;
    request.instructor = this.loginService.getInstructor();
    console.log(request);
    this.requestInstructorService.updateRequest(request).subscribe(
      request => {
        this.request = request;
        console.log("Request "+ this.request);
        this.route.navigate(['/requests/instructor']);
      }
    );
  }
  rejectReq(request: Request): void {
    console.log(request);
    request.status = new Status();
    request.status.statusId = 3;
    request.status.statusType = 'REJECTED';
    request.instructor =this.loginService.getInstructor();
    console.log(request);
    this.requestInstructorService.updateRequest(request).subscribe(
      request => {
        this.request = request;
        console.log("Request "+ this.request);
        this.route.navigate(['/requests/instructor']);
      }
    );

  }
  isInstrument(inventory): boolean{
    if (inventory.instrumentName){
      return true;
    }else{
      return false;
    }
  }


}
