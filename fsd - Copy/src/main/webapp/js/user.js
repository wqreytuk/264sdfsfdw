var vue = new Vue({
    el: "#app",
    data: {
        user: {id:"",username:"",password:"",age:"",sex:"",email:""},
        userList: []
    },
    methods: {
        //发送ajax请求
        findAll: function() {
            var _this = this;
            //因为filter中配置的是*.do，所以我们在请求的时候也要加上.do
            axios.get("/fsd_war_exploded/user/findAll.do")
                .then(function (response) {
                _this.userList = response.data;
                console.log(_this.userList);
            }).catch(function (err) {
                console.log(err);
            });
        },
        findById: function (userid) {
            var _this = this;
            axios.get("/fsd_war_exploded/user/findById.do", {
                params: {
                    id: userid
                }
            })
                .then(function (response) {
                _this.user = response.data;
                $('#myModal').modal("show");
            }).catch(function (err) {
            });

        },
        update: function (user) {
            var _this = this;
            axios.post("/fsd_war_exploded/user/update.do",_this.user)
                .then(function (response) {
                _this.findAll();
            }).catch(function (err) {
            });
        }
    },
    //在页面加载的时候就会执行findAll方法
    created: function() {
        this.findAll();
    }
});