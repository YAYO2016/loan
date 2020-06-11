const Home = () => import('../pages/home/Home');
const Login = () => import('../pages/login/Login');

const Business = () => import('../pages/business/Business');
const Company = () => import('../pages/business/components/Company');
const Deparment = () => import('../pages/business/components/Department');
const Person = () => import('../pages/business/components/Person');

const Case = () => import('../pages/case/Case');
const WorkBench = () => import('../pages/case/components/WorkBench');
const HistoryCase = () => import('../pages/case/components/HistoryCase');
const CaseDetail = () => import('../pages/case/components/CaseDetail');
const BasicInformation = () => import('../pages/case/components/caseDetailComponents/BasicInformation');
const LoanInformation = () => import('../pages/case/components/caseDetailComponents/LoanInformation');
const CollateralInformation = () => import('../pages/case/components/caseDetailComponents/CollateralInformation');
const PrincipalLenderInformation = () => import('../pages/case/components/caseDetailComponents/PrincipalLenderInformation');
const DeveloperInformation = () => import('../pages/case/components/caseDetailComponents/DeveloperInformation');
const SellerInformation = () => import('../pages/case/components/caseDetailComponents/SellerInformation');
const ChannelInformation = () => import('../pages/case/components/caseDetailComponents/ChannelInformation');
const MaterialInformation = () => import('../pages/case/components/caseDetailComponents/MaterialInformation');
const FeelInformation = () => import('../pages/case/components/caseDetailComponents/FeelInformation');

const System = () => import('../pages/system/System');
const Channel = () => import('../pages/system/components/Channel');
const Users = () => import('../pages/system/components/Users');
const Organizations = () => import('../pages/system/components/Organizations');
const Feels = () => import('../pages/system/components/Feels');
const Banks = () => import('../pages/system/components/Banks');
const Materials = () => import('../pages/system/components/Materials');
const Developers = () => import('../pages/system/components/Developers');
const RoleManage = () => import('../pages/system/components/RoleManage');
const MessageManage = () => import('../pages/system/components/MessageManage');

const OverView = () => import('../pages/caseview/components/OverView');
const noFound = () => import('../pages/nofound/NoFound');

const privilegesAll = ['LFR01','LFR02','LFR03'];
// const roleOne = ['R0101', 'R0301', 'R0401'];
const routes = [
  {
    path: '/login',
    name: 'Login',
    component: Login,
    meta: {requireAuth: false,privileges: privilegesAll},
  },
  {
    path: '/',
    name: 'Home',
    meta: {requireAuth: true, privileges: privilegesAll},
    redirect: '/case/workbench',
    component: Home,
    children: [
      {
        path: 'business', component: Business, name: 'Business', meta: {requireAuth: true, privileges: ['LFR01']},
        children: [
          {path: 'company', component: Company, name: 'Company', meta: {requireAuth: true, privileges: ['LFR01001']}},
          {path: 'department', component: Deparment, name: 'Deparment', meta: {requireAuth: true, privileges: ['LFR01002']}},
          {path: 'person', component: Person, name: 'Person', meta: {requireAuth: true, privileges: ['LFR01003']}},
        ]
      },
      {
        path: 'case', component: Case, name: 'Case', meta: {requireAuth: true, privileges: ['LFR02']},
        children: [
          //工作台
          {path: 'workbench', component: WorkBench, name: 'WorkBench', meta: {requireAuth: true, privileges: ['LFR02']}},
          {
            path: 'caseDetail', component: CaseDetail, name: 'CaseDetail', meta: {requireAuth: true, privileges: ['LFR02']},
            children:[
              {
                path: 'basicInformation/:caseId',
                component: BasicInformation,
                name: 'BasicInformation',
                meta: {requireAuth: true, privileges: ['LFR02']}
              },
              {
                path: 'loanInformation/:caseId',
                component: LoanInformation,
                name: 'LoanInformation',
                meta: {requireAuth: true, privileges: ['LFR02']}
              },
              {
                path: 'collateralInformation/:caseId',
                component: CollateralInformation,
                name: 'CollateralInformation',
                meta: {requireAuth: true, privileges: ['LFR02']}
              },
              {
                path: 'principalLenderInformation/:caseId',
                component: PrincipalLenderInformation,
                name: 'PrincipalLenderInformation',
                meta: {requireAuth: true, privileges: ['LFR02']}
              },
              {
                path: 'developerInformation/:caseId',
                component: DeveloperInformation,
                name: 'DeveloperInformation',
                meta: {requireAuth: true, privileges: ['LFR02']}
              },
              {
                path: 'sellerInformation/:caseId',
                component: SellerInformation,
                name: 'SellerInformation',
                meta: {requireAuth: true, privileges: ['LFR02']}
              },
              {
                path: 'channelInformation/:caseId',
                component: ChannelInformation,
                name: 'ChannelInformation',
                meta: {requireAuth: true, privileges: ['LFR02']}
              },
              {
                path: 'materialInformation/:caseId',
                component: MaterialInformation,
                name: 'MaterialInformation',
                meta: {requireAuth: true, privileges: ['LFR02']}
              },
              {
                path: 'feelInformation/:caseId',
                component: FeelInformation,
                name: 'FeelInformation',
                meta: {requireAuth: true, privileges: ['LFR02']}
              },
            ]
          },
          {path: 'historyCase', component: HistoryCase, name: 'HistoryCase', meta: {requireAuth: true, privileges: ['LFR02003']}},
        ]
      },
      {
        path: 'system', component: System, name: 'System', meta: {requireAuth: true,privileges: ['LFR03']},
        children: [
          //渠道管理
          {path: 'channel', component: Channel, name: 'Channel', meta: {requireAuth: true, privileges: ['LFR03002']}},
          //用户管理
          {path: 'users', component: Users, name: 'Users', meta: {requireAuth: true, privileges: ['LFR03003']}},
          //组织机构管理
          {path: 'organizations', component: Organizations, name: 'Organizations', meta: {requireAuth: true, privileges: ['LFR03004']}},
          //费用科目管理
          {path: 'feels', component: Feels, name: 'Feels', meta: {requireAuth: true, privileges: ['LFR03006']}},
          //银行
          {path: 'banks', component: Banks, name: 'Banks', meta: {requireAuth: true, privileges: ['LFR03001']}},
          //材料
          {path: 'materials', component: Materials, name: 'Materials', meta: {requireAuth: true, privileges: ['LFR03007']}},
          //开发商
          {path: 'developers', component: Developers, name: 'Developers', meta: {requireAuth: true, privileges: ['LFR03008']}},
          //角色权限管理
          {path: 'roleManage', component: RoleManage, name: 'RoleManage', meta: {requireAuth: true, privileges: ['LFR03009']}},
          // 通知管理
          {path: 'messageManege', component: MessageManage, name: 'MessageManage', meta: {requireAuth: true, privileges: ['LFR03005']}},
        ]
      },
      {path: 'caseview/:caseId', component: OverView, name: 'OverView', meta: {requireAuth: true, privileges: ['LFR02002']}},
    ]
  },
  {path: '/noFound', component: noFound, name: 'NoFound', meta: {requireAuth: true, roles: privilegesAll}},
];

export default routes;

