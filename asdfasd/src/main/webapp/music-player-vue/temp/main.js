const testComponent = Vue.extend({
  template: '<div>{{ text }}</div>',
  data: function () {
    return {
      text: 'extend test'
    }
  }
})

const extendComponent = new testComponent().$mount()

document.getElementById("test").appendChild(extendComponent.$el)