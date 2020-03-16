import { TestBed } from '@angular/core/testing';

import { RequestInstructorService } from './request-instructor.service';

describe('RequestInstructorService', () => {
  let service: RequestInstructorService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(RequestInstructorService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
