if (typeof kotlin === 'undefined') {
  throw new Error("Error loading module 'app'. Its dependency 'kotlin' was not found. Please, check whether 'kotlin' is loaded prior to 'app'.");
}
var app = function (_, Kotlin) {
  'use strict';
  var println = Kotlin.kotlin.io.println_s8jyv4$;
  function main(args) {
    showAlert();
  }
  function showAlert() {
    var number = Math.floor(Math.random() * 1000);
    var message = number.toString() + ' viruses found on your computer!';
    println('showing alert');
    alert(message);
  }
  var package$chapter9 = _.chapter9 || (_.chapter9 = {});
  package$chapter9.main_kand9s$ = main;
  package$chapter9.showAlert = showAlert;
  main([]);
  Kotlin.defineModule('app', _);
  return _;
}(typeof app === 'undefined' ? {} : app, kotlin);

//# sourceMappingURL=app.js.map
