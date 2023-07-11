import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TemplateParamComponent } from './template-param.component';

describe('AddTemplateComponent', () => {
  let component: TemplateParamComponent;
  let fixture: ComponentFixture<TemplateParamComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ TemplateParamComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TemplateParamComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
