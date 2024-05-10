import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import {ToastModule} from 'primeng/toast';
import {ToolbarModule} from 'primeng/toolbar';
import {TableModule} from 'primeng/table';
import {DropdownModule} from 'primeng/dropdown';
import {InputSwitchModule} from 'primeng/inputswitch';
import {InputTextareaModule} from 'primeng/inputtextarea';

import { ConfirmDialogModule } from 'primeng/confirmdialog';
import { DialogModule } from 'primeng/dialog';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {CalendarModule} from 'primeng/calendar';
import {PanelModule} from 'primeng/panel';
import {InputNumberModule} from 'primeng/inputnumber';
import {BadgeModule} from 'primeng/badge';
import { MultiSelectModule } from 'primeng/multiselect';
import {TranslateModule} from '@ngx-translate/core';
import {FileUploadModule} from 'primeng/fileupload';
import {FullCalendarModule} from '@fullcalendar/angular';
import {CardModule} from "primeng/card";

import { EmailGroupePieceJointCreateAdminComponent } from './email-groupe-piece-joint/create/email-groupe-piece-joint-create-admin.component';
import { EmailGroupePieceJointEditAdminComponent } from './email-groupe-piece-joint/edit/email-groupe-piece-joint-edit-admin.component';
import { EmailGroupePieceJointViewAdminComponent } from './email-groupe-piece-joint/view/email-groupe-piece-joint-view-admin.component';
import { EmailGroupePieceJointListAdminComponent } from './email-groupe-piece-joint/list/email-groupe-piece-joint-list-admin.component';
import { GroupeEmailCreateAdminComponent } from './groupe-email/create/groupe-email-create-admin.component';
import { GroupeEmailEditAdminComponent } from './groupe-email/edit/groupe-email-edit-admin.component';
import { GroupeEmailViewAdminComponent } from './groupe-email/view/groupe-email-view-admin.component';
import { GroupeEmailListAdminComponent } from './groupe-email/list/groupe-email-list-admin.component';
import { EmailDetailGroupCreateAdminComponent } from './email-detail-group/create/email-detail-group-create-admin.component';
import { EmailDetailGroupEditAdminComponent } from './email-detail-group/edit/email-detail-group-edit-admin.component';
import { EmailDetailGroupViewAdminComponent } from './email-detail-group/view/email-detail-group-view-admin.component';
import { EmailDetailGroupListAdminComponent } from './email-detail-group/list/email-detail-group-list-admin.component';
import { GroupeEmailDetailCreateAdminComponent } from './groupe-email-detail/create/groupe-email-detail-create-admin.component';
import { GroupeEmailDetailEditAdminComponent } from './groupe-email-detail/edit/groupe-email-detail-edit-admin.component';
import { GroupeEmailDetailViewAdminComponent } from './groupe-email-detail/view/groupe-email-detail-view-admin.component';
import { GroupeEmailDetailListAdminComponent } from './groupe-email-detail/list/groupe-email-detail-list-admin.component';

import { PasswordModule } from 'primeng/password';
import { InputTextModule } from 'primeng/inputtext';
import {ButtonModule} from 'primeng/button';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import {RouterModule} from '@angular/router';
import {TabViewModule} from 'primeng/tabview';
import { SplitButtonModule } from 'primeng/splitbutton';
import { MessageModule } from 'primeng/message';
import {MessagesModule} from 'primeng/messages';
import {PaginatorModule} from 'primeng/paginator';



@NgModule({
  declarations: [

    EmailGroupePieceJointCreateAdminComponent,
    EmailGroupePieceJointListAdminComponent,
    EmailGroupePieceJointViewAdminComponent,
    EmailGroupePieceJointEditAdminComponent,
    GroupeEmailCreateAdminComponent,
    GroupeEmailListAdminComponent,
    GroupeEmailViewAdminComponent,
    GroupeEmailEditAdminComponent,
    EmailDetailGroupCreateAdminComponent,
    EmailDetailGroupListAdminComponent,
    EmailDetailGroupViewAdminComponent,
    EmailDetailGroupEditAdminComponent,
    GroupeEmailDetailCreateAdminComponent,
    GroupeEmailDetailListAdminComponent,
    GroupeEmailDetailViewAdminComponent,
    GroupeEmailDetailEditAdminComponent,
  ],
  imports: [
    CommonModule,
    ToastModule,
    ToolbarModule,
    TableModule,
    ConfirmDialogModule,
    DialogModule,
    PasswordModule,
    InputTextModule,
    ButtonModule,
    FormsModule,
    ReactiveFormsModule,
    RouterModule,
    SplitButtonModule,
    BrowserAnimationsModule,
    DropdownModule,
    TabViewModule,
    InputSwitchModule,
    InputTextareaModule,
    CalendarModule,
    PanelModule,
    MessageModule,
    MessagesModule,
    InputNumberModule,
    BadgeModule,
    MultiSelectModule,
    PaginatorModule,
    TranslateModule,
    FileUploadModule,
    FullCalendarModule,
    CardModule,

  ],
  exports: [
  EmailGroupePieceJointCreateAdminComponent,
  EmailGroupePieceJointListAdminComponent,
  EmailGroupePieceJointViewAdminComponent,
  EmailGroupePieceJointEditAdminComponent,
  GroupeEmailCreateAdminComponent,
  GroupeEmailListAdminComponent,
  GroupeEmailViewAdminComponent,
  GroupeEmailEditAdminComponent,
  EmailDetailGroupCreateAdminComponent,
  EmailDetailGroupListAdminComponent,
  EmailDetailGroupViewAdminComponent,
  EmailDetailGroupEditAdminComponent,
  GroupeEmailDetailCreateAdminComponent,
  GroupeEmailDetailListAdminComponent,
  GroupeEmailDetailViewAdminComponent,
  GroupeEmailDetailEditAdminComponent,
  ],
})
export class EmailgroupAdminModule { }
