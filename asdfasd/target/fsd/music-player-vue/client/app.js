(function (Vue) {
  //es6推荐我们使用const声明变量，因为const是块作用域，也就是{}包括的区域，比如函数、if语句等等
const App = Vue.extend({});

const Home = Vue.extend({ template: '<h1>Home</h1>' });
const List = Vue.extend({ template: '<h1>List</h1>' });
const Item = Vue.extend({ template: '<h1>Item</h1>' });

const router = new VueRouter();

router.map({
  '/home':{
    name: 'home',
    component:Home
  },
  '/songs':{
    name: 'list',
    component:List
  },
  '/songs/:id':{
    name: 'item',
    component:Item
  },
});

router.start(App, '#app');
})(Vue);