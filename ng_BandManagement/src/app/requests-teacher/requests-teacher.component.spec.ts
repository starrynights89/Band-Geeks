import { async, ComponentFixture, TestBed } from '@angular/core/testing';

import { RequestsTeacherComponent } from './requests-teacher.component';

describe('RequestsTeacherComponent', () => {
  let component: RequestsTeacherComponent;
  let fixture: ComponentFixture<RequestsTeacherComponent>;

  beforeEach(async(() => {
    TestBed.configureTestingModule({
      declarations: [ RequestsTeacherComponent ]
    })
    .compileComponents();
  }));

  beforeEach(() => {
    fixture = TestBed.createComponent(RequestsTeacherComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
