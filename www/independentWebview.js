var exec = require('cordova/exec')
var IndependentwebviewPlugin = {
  open: function(url) {
    exec(function() {}, function() {}, 'IndependentwebviewPlugin', 'open', [
      url
    ])
  }
}
module.exports = IndependentwebviewPlugin
