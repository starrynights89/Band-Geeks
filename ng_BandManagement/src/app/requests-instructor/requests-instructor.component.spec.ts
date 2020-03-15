import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RequestsInstructorComponent } from './requests-instructor.component';

describe('RequestsInstructorComponent', () => {
  let component: RequestsInstructorComponent;
  let fixture: ComponentFixture<RequestsInstructorComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RequestsInstructorComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RequestsInstructorComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
