import { ComponentFixture, TestBed } from '@angular/core/testing';

import { EmotionSurveyComponent } from './emotion-survey.component';

describe('EmotionSurveyComponent', () => {
  let component: EmotionSurveyComponent;
  let fixture: ComponentFixture<EmotionSurveyComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ EmotionSurveyComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(EmotionSurveyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
