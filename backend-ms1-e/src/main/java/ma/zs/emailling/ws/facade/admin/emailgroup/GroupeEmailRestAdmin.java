package  ma.zs.emailling.ws.facade.admin.emailgroup;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.emailling.bean.core.emailgroup.GroupeEmail;
import ma.zs.emailling.dao.criteria.core.emailgroup.GroupeEmailCriteria;
import ma.zs.emailling.service.facade.admin.emailgroup.GroupeEmailAdminService;
import ma.zs.emailling.ws.converter.emailgroup.GroupeEmailConverter;
import ma.zs.emailling.ws.dto.emailgroup.GroupeEmailDto;
import ma.zs.emailling.zynerator.controller.AbstractController;
import ma.zs.emailling.zynerator.dto.AuditEntityDto;
import ma.zs.emailling.zynerator.util.PaginatedList;


import org.springframework.core.io.InputStreamResource;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import ma.zs.emailling.zynerator.process.Result;


import org.springframework.web.multipart.MultipartFile;
import ma.zs.emailling.zynerator.dto.FileTempDto;

@RestController
@RequestMapping("/api/admin/groupeEmail/")
public class GroupeEmailRestAdmin  extends AbstractController<GroupeEmail, GroupeEmailDto, GroupeEmailCriteria, GroupeEmailAdminService, GroupeEmailConverter> {



    @Operation(summary = "upload one groupeEmail")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple groupeEmails")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all groupeEmails")
    @GetMapping("")
    public ResponseEntity<List<GroupeEmailDto>> findAll() throws Exception {
        return super.findAll();
    }



    @Operation(summary = "Saves the specified  groupeEmail")
    @PostMapping("")
    public ResponseEntity<GroupeEmailDto> save(@RequestBody GroupeEmailDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  groupeEmail")
    @PutMapping("")
    public ResponseEntity<GroupeEmailDto> update(@RequestBody GroupeEmailDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of groupeEmail")
    @PostMapping("multiple")
    public ResponseEntity<List<GroupeEmailDto>> delete(@RequestBody List<GroupeEmailDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified groupeEmail")
    @DeleteMapping("")
    public ResponseEntity<GroupeEmailDto> delete(@RequestBody GroupeEmailDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified groupeEmail")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple groupeEmails by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by adminGroupe id")
    @GetMapping("adminGroupe/id/{id}")
    public List<GroupeEmailDto> findByAdminGroupeId(@PathVariable Long id){
        return findDtos(service.findByAdminGroupeId(id));
    }
    @Operation(summary = "delete by adminGroupe id")
    @DeleteMapping("adminGroupe/id/{id}")
    public int deleteByAdminGroupeId(@PathVariable Long id){
        return service.deleteByAdminGroupeId(id);
    }

    @Operation(summary = "Finds a groupeEmail and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<GroupeEmailDto> findById(@PathVariable Long id) {
        return super.findWithAssociatedLists(id);
    }

    @Operation(summary = "Finds groupeEmails by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<GroupeEmailDto>> findByCriteria(@RequestBody GroupeEmailCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated groupeEmails by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody GroupeEmailCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports groupeEmails by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody GroupeEmailCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets groupeEmail data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody GroupeEmailCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public GroupeEmailRestAdmin (GroupeEmailAdminService service, GroupeEmailConverter converter) {
        super(service, converter);
    }




}
