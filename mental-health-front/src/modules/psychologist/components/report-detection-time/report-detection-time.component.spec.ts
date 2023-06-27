import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ReportDetectionTimeComponent } from './report-detection-time.component';

describe('ReportDetectionTimeComponent', () => {
  let component: ReportDetectionTimeComponent;
  let fixture: ComponentFixture<ReportDetectionTimeComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ReportDetectionTimeComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ReportDetectionTimeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
