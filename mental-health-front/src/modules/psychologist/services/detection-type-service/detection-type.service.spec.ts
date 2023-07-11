import { TestBed } from '@angular/core/testing';

import { DetectionTypeService } from './detection-type.service';

describe('DetectionTypeService', () => {
  let service: DetectionTypeService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(DetectionTypeService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
