import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReportBasedOnJobAgeComponent } from './report-based-on-job-age.component';

describe('ReportBasedOnJobAgeComponent', () => {
  let component: ReportBasedOnJobAgeComponent;
  let fixture: ComponentFixture<ReportBasedOnJobAgeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReportBasedOnJobAgeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ReportBasedOnJobAgeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
