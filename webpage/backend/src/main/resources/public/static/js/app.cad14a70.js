(function(){"use strict";var n={9687:function(n,e,o){var t=o(9242),r=o(2483),u=o(3396),i=o.p+"static/img/silvy.6030dfaf.jpg";const a=(0,u._)("img",{src:i,class:"contained top-background",alt:"..."},null,-1);function c(n,e,o,t,r,i){const c=(0,u.up)("Navbar"),l=(0,u.up)("Home");return(0,u.wg)(),(0,u.iD)("div",null,[(0,u.Wm)(c),(0,u.Wm)(l),a])}function l(n,e,o,t,r,i){return(0,u.wg)(),(0,u.iD)("p",null,"home stuff")}var s={data(){return{count:0}}},f=o(89);const p=(0,f.Z)(s,[["render",l]]);var d=p,_=o(7139);const h={id:"nav",class:"text-center"},v={class:"row"},m={id:"welcome_text"},g={class:"row"},w=(0,u._)("p",null,"_________________________",-1),b={class:"row"},y={class:"col"},k={class:"col"},O={class:"col"};function D(n,e,o,t,r,i){return(0,u.wg)(),(0,u.iD)("nav",h,[(0,u._)("div",v,[(0,u._)("h4",m,(0,_.zw)(n.$t("message.welcome")),1)]),(0,u._)("div",g,[(0,u._)("h1",null,(0,_.zw)(n.$t("topics.pension_lucke")),1)]),w,(0,u._)("div",b,[(0,u._)("div",y,[(0,u._)("h2",null,(0,_.zw)(n.$t("topics.pension")),1)]),(0,u._)("div",k,[(0,u._)("h2",null,(0,_.zw)(n.$t("topics.agility")),1)]),(0,u._)("div",O,[(0,u._)("h2",null,(0,_.zw)(n.$t("topics.therapyDog")),1)])])])}var W={data(){return{}}};const j=(0,f.Z)(W,[["render",D]]);var z=j,$={components:{Home:d,Navbar:z}};const x=(0,f.Z)($,[["render",c]]);var A=x;const H=(0,u._)("h1",null,"About",-1),Z=[H];function N(n,e){return(0,u.wg)(),(0,u.iD)("div",null,Z)}const P={},T=(0,f.Z)(P,[["render",N]]);var U=T;function L(n,e){const o=(0,u.up)("router-link");return(0,u.wg)(),(0,u.iD)("div",null,[(0,u._)("h1",null,(0,_.zw)(n.$t("page.not_found")),1),(0,u._)("p",null,[(0,u.Uk)((0,_.zw)(n.$t("message.not_found"))+" ",1),(0,u.Wm)(o,{to:"/"},{default:(0,u.w5)((()=>[(0,u.Uk)((0,_.zw)(n.$t("page.home")),1)])),_:1})])])}const C={},F=(0,f.Z)(C,[["render",L]]);var M=F;const V=[{path:"/",name:"Home",component:A},{path:"/about",name:"About",component:U},{path:"/:pathMatch(.*)*",name:"NotFound",component:M}],E=(0,r.p7)({history:(0,r.PO)(),routes:V});var I=E,Y=o(7853);const q={en:{page:{home:"Home",about:"About",not_found:"Not found"},topics:{pension_lucke:"family Lücke",therapyDog:"therapy-dog",pension:"horse boarding",agility:"agility-courses"},message:{hello:"hello world",welcome:"Welcome",not_found:"Ooops, we couldn´t find what you were looking for. Try it here "}},de:{page:{home:"Hauptseite",about:"Über uns",not_found:"Nicht gefunden"},topics:{pension_lucke:"Pferdehof Lücke",therapyDog:"Therapiehund",pension:"Pferdepension",agility:"Agilitykurse"},message:{hello:"Hallo Welt",welcome:"Wilkommen",not_found:"Ooops, wir konnten deine Anfrage nicht finden. Versuche es hier "}}};var B=q;const G=(0,Y.o)({locale:"de",fallbackLocale:"en",messages:B,legacy:!1,globalInjection:!0});var J=G;const K={id:"router-container"};function Q(n,e,o,t,r,i){const a=(0,u.up)("router-link"),c=(0,u.up)("routerView");return(0,u.wg)(),(0,u.iD)(u.HY,null,[(0,u.Wm)(a,{to:"/"},{default:(0,u.w5)((()=>[(0,u.Uk)("home")])),_:1}),(0,u.Wm)(a,{to:"/about"},{default:(0,u.w5)((()=>[(0,u.Uk)("About")])),_:1}),(0,u._)("div",K,[(0,u.Wm)(c)])],64)}var R={name:"App",components:{}};const S=(0,f.Z)(R,[["render",Q]]);var X=S;const nn=(0,t.ri)(X);nn.use(I),nn.use(J),nn.mount("#app")}},e={};function o(t){var r=e[t];if(void 0!==r)return r.exports;var u=e[t]={exports:{}};return n[t].call(u.exports,u,u.exports,o),u.exports}o.m=n,function(){var n=[];o.O=function(e,t,r,u){if(!t){var i=1/0;for(s=0;s<n.length;s++){t=n[s][0],r=n[s][1],u=n[s][2];for(var a=!0,c=0;c<t.length;c++)(!1&u||i>=u)&&Object.keys(o.O).every((function(n){return o.O[n](t[c])}))?t.splice(c--,1):(a=!1,u<i&&(i=u));if(a){n.splice(s--,1);var l=r();void 0!==l&&(e=l)}}return e}u=u||0;for(var s=n.length;s>0&&n[s-1][2]>u;s--)n[s]=n[s-1];n[s]=[t,r,u]}}(),function(){o.n=function(n){var e=n&&n.__esModule?function(){return n["default"]}:function(){return n};return o.d(e,{a:e}),e}}(),function(){o.d=function(n,e){for(var t in e)o.o(e,t)&&!o.o(n,t)&&Object.defineProperty(n,t,{enumerable:!0,get:e[t]})}}(),function(){o.g=function(){if("object"===typeof globalThis)return globalThis;try{return this||new Function("return this")()}catch(n){if("object"===typeof window)return window}}()}(),function(){o.o=function(n,e){return Object.prototype.hasOwnProperty.call(n,e)}}(),function(){o.p="/"}(),function(){var n={143:0};o.O.j=function(e){return 0===n[e]};var e=function(e,t){var r,u,i=t[0],a=t[1],c=t[2],l=0;if(i.some((function(e){return 0!==n[e]}))){for(r in a)o.o(a,r)&&(o.m[r]=a[r]);if(c)var s=c(o)}for(e&&e(t);l<i.length;l++)u=i[l],o.o(n,u)&&n[u]&&n[u][0](),n[u]=0;return o.O(s)},t=self["webpackChunkfrontend"]=self["webpackChunkfrontend"]||[];t.forEach(e.bind(null,0)),t.push=e.bind(null,t.push.bind(t))}();var t=o.O(void 0,[998],(function(){return o(9687)}));t=o.O(t)})();
//# sourceMappingURL=app.cad14a70.js.map