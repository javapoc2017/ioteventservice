'use strict';

describe('Service: serviceCalls', function () {

  // load the service's module
  beforeEach(module('iotClientApp'));

  // instantiate service
  var serviceCalls;
  beforeEach(inject(function (_serviceCalls_) {
    serviceCalls = _serviceCalls_;
  }));

  it('should do something', function () {
    expect(!!serviceCalls).toBe(true);
  });

});
