import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmotionSurveyOverviewComponent } from './emotion-survey-overview.component';

describe('EmotionSurveyOverviewComponent', () => {
  let component: EmotionSurveyOverviewComponent;
  let fixture: ComponentFixture<EmotionSurveyOverviewComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EmotionSurveyOverviewComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EmotionSurveyOverviewComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
