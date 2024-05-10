package  ma.zs.emailling.ws.facade.admin.emailgroup;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

import ma.zs.emailling.bean.core.emailgroup.GroupeEmailDetail;
import ma.zs.emailling.dao.criteria.core.emailgroup.GroupeEmailDetailCriteria;
import ma.zs.emailling.service.facade.admin.emailgroup.GroupeEmailDetailAdminService;
import ma.zs.emailling.ws.converter.emailgroup.GroupeEmailDetailConverter;
import ma.zs.emailling.ws.dto.emailgroup.GroupeEmailDetailDto;
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
@RequestMapping("/api/admin/groupeEmailDetail/")
public class GroupeEmailDetailRestAdmin  extends AbstractController<GroupeEmailDetail, GroupeEmailDetailDto, GroupeEmailDetailCriteria, GroupeEmailDetailAdminService, GroupeEmailDetailConverter> {



    @Operation(summary = "upload one groupeEmailDetail")
    @RequestMapping(value = "upload", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<FileTempDto> uploadFileAndGetChecksum(@RequestBody MultipartFile file) throws Exception {
        return super.uploadFileAndGetChecksum(file);
    }
    @Operation(summary = "upload multiple groupeEmailDetails")
    @RequestMapping(value = "upload-multiple", method = RequestMethod.POST, consumes = "multipart/form-data")
    public ResponseEntity<List<FileTempDto>> uploadMultipleFileAndGetChecksum(@RequestBody MultipartFile[] files) throws Exception {
        return super.uploadMultipleFileAndGetChecksum(files);
    }

    @Operation(summary = "Finds a list of all groupeEmailDetails")
    @GetMapping("")
    public ResponseEntity<List<GroupeEmailDetailDto>> findAll() throws Exception {
        return super.findAll();
    }



    @Operation(summary = "Saves the specified  groupeEmailDetail")
    @PostMapping("")
    public ResponseEntity<GroupeEmailDetailDto> save(@RequestBody GroupeEmailDetailDto dto) throws Exception {
        return super.save(dto);
    }

    @Operation(summary = "Updates the specified  groupeEmailDetail")
    @PutMapping("")
    public ResponseEntity<GroupeEmailDetailDto> update(@RequestBody GroupeEmailDetailDto dto) throws Exception {
        return super.update(dto);
    }

    @Operation(summary = "Delete list of groupeEmailDetail")
    @PostMapping("multiple")
    public ResponseEntity<List<GroupeEmailDetailDto>> delete(@RequestBody List<GroupeEmailDetailDto> listToDelete) throws Exception {
        return super.delete(listToDelete);
    }
    @Operation(summary = "Delete the specified groupeEmailDetail")
    @DeleteMapping("")
    public ResponseEntity<GroupeEmailDetailDto> delete(@RequestBody GroupeEmailDetailDto dto) throws Exception {
            return super.delete(dto);
    }

    @Operation(summary = "Delete the specified groupeEmailDetail")
    @DeleteMapping("id/{id}")
    public ResponseEntity<Long> deleteById(@PathVariable Long id) throws Exception {
        return super.deleteById(id);
    }
    @Operation(summary = "Delete multiple groupeEmailDetails by ids")
    @DeleteMapping("multiple/id")
    public ResponseEntity<List<Long>> deleteByIdIn(@RequestBody List<Long> ids) throws Exception {
            return super.deleteByIdIn(ids);
     }


    @Operation(summary = "find by personne id")
    @GetMapping("personne/id/{id}")
    public List<GroupeEmailDetailDto> findByPersonneId(@PathVariable Long id){
        return findDtos(service.findByPersonneId(id));
    }
    @Operation(summary = "delete by personne id")
    @DeleteMapping("personne/id/{id}")
    public int deleteByPersonneId(@PathVariable Long id){
        return service.deleteByPersonneId(id);
    }
    @Operation(summary = "find by groupeEmail id")
    @GetMapping("groupeEmail/id/{id}")
    public List<GroupeEmailDetailDto> findByGroupeEmailId(@PathVariable Long id){
        return findDtos(service.findByGroupeEmailId(id));
    }
    @Operation(summary = "delete by groupeEmail id")
    @DeleteMapping("groupeEmail/id/{id}")
    public int deleteByGroupeEmailId(@PathVariable Long id){
        return service.deleteByGroupeEmailId(id);
    }

    @Operation(summary = "Finds a groupeEmailDetail and associated list by id")
    @GetMapping("id/{id}")
    public ResponseEntity<GroupeEmailDetailDto> findById(@PathVariable Long id) {
        return super.findById(id);
    }

    @Operation(summary = "Finds groupeEmailDetails by criteria")
    @PostMapping("find-by-criteria")
    public ResponseEntity<List<GroupeEmailDetailDto>> findByCriteria(@RequestBody GroupeEmailDetailCriteria criteria) throws Exception {
        return super.findByCriteria(criteria);
    }

    @Operation(summary = "Finds paginated groupeEmailDetails by criteria")
    @PostMapping("find-paginated-by-criteria")
    public ResponseEntity<PaginatedList> findPaginatedByCriteria(@RequestBody GroupeEmailDetailCriteria criteria) throws Exception {
        return super.findPaginatedByCriteria(criteria);
    }

    @Operation(summary = "Exports groupeEmailDetails by criteria")
    @PostMapping("export")
    public ResponseEntity<InputStreamResource> export(@RequestBody GroupeEmailDetailCriteria criteria) throws Exception {
        return super.export(criteria);
    }

    @Operation(summary = "Gets groupeEmailDetail data size by criteria")
    @PostMapping("data-size-by-criteria")
    public ResponseEntity<Integer> getDataSize(@RequestBody GroupeEmailDetailCriteria criteria) throws Exception {
        return super.getDataSize(criteria);
    }



    public GroupeEmailDetailRestAdmin (GroupeEmailDetailAdminService service, GroupeEmailDetailConverter converter) {
        super(service, converter);
    }




}
