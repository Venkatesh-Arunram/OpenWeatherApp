import { TestBed } from '@angular/core/testing';

import { OperWeatherServiceService } from './oper-weather-service.service';

describe('OperWeatherServiceService', () => {
  beforeEach(() => TestBed.configureTestingModule({}));

  it('should be created', () => {
    const service: OperWeatherServiceService = TestBed.get(OperWeatherServiceService);
    expect(service).toBeTruthy();
  });
});
